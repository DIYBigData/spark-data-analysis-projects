# Loading Pushshidt.io Data
In order to fetch data from [pushshoft.io](https://files.pushshift.io/reddit/), use the shell script [download_and_convert_to_bz2.sh](./download_and_convert_to_bz2.sh) to download the comments and/or submissions files and convert them to a `bz` compressions format, which works better with Spark. The Jupyter notebooks in this directory for loading the pushshift.io downloads to parquet expect the files to being `bz2` compressed.

# Reddit Comment Data Analysis
The analyses in this directory pertain to the Reddit Comments Data that can be [downloaded here](http://academictorrents.com/details/85a5bd50e4c365f8df70240ffd4ecc7dec59912b). When analyzing this da, the first step that must be done is to load it into the parquet file format. All analyses in this directory expects that the data has been loaded into the parquet file format as implemented in the `reddit-load-to-parquet` notebook.

The analyses performed on this data set are:
* *Identification of Bot Commenters* (`reddit-bot-commenters`) - This analysis uses Benford's Law to identify the commenters on Reddit that are most likely to be bots based on their commenting patterns.

