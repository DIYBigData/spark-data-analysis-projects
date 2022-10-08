#!/bin/bash

#
# there should be two arguments.
#    $1 - the directory finalized files should be placed in
#    $2 - the file containing the URLs to download, one per line.
#
# The following tools should be installed on your system:
#    - bzip2
#    - xz-utils
#    - zstd
#

NUM_COMPRESSION_THREADS=12

if [ $# -ne 2 ]; then
    echo "usage: download_and_convert_to_bz2.sh /path/to/destination/directory /path/to/url_list.txt"
    exit 1
fi

# manage arguments
destination_dir=${1%/}
readarray url_list < $2

# the main loop
echo "Fetching URLs list in ${2}"
for url in ${url_list[@]}; do
    echo "Processing URL = ${url}"
    download_file_name="${url##*/}"
    download_file_extension="${download_file_name##*.}"
    uncompressed_file_name="${download_file_name%.*}"
    final_file_name=${download_file_name}

    # download the files
    wget $url

    # if file extension of download is not bz2 deompress and recompress as bz2
    if [ "$download_file_extension" != "bz2" ]; then
        if [ "$download_file_extension" == "zst" ]; then
            zstd -v -d --memory=2048MB $download_file_name
        elif [ "$download_file_extension" == "xz" ]; then
            xz -v -k -T $NUM_COMPRESSION_THREADS -d $download_file_name
        else
            echo "Unrecognized file type for ${url}"
            exit 1
        fi
        lbzip2 -v -n $((NUM_COMPRESSION_THREADS)) $uncompressed_file_name
        rm $download_file_name
        final_file_name="${uncompressed_file_name}.bz2"
    fi
    mv -v -f $final_file_name $destination_dir
    echo "Finalized ${final_file_name}"
    echo ""
done

echo "Finished processing $2"
exit 0
