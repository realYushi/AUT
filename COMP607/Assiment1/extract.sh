#!/bin/zsh
#Name: Yushi Cui
#Student ID: 23196152
# This script extracts lines containing "special" from a text file and writes them to a special file.

# Command-line arguments:
# $1 - Input text file
# $2 - Directory for the special file

text_file=$1
output_directory=$2
is_append=false
special_file="$output_directory/special.txt"

# Check if the correct number of arguments is provided
if [[ $# -ne 2 ]]; then
    echo "Usage: extract.sh text_file directory"
    exit 1
fi

# Check if the text file argument is provided
if [[ ! -f $text_file ]]; then
    echo "Error: Input file '$text_file' does not exist"
    exit 1
fi
# Create the directory if it doesn't exist
if [[ ! -d $output_directory ]]; then
    mkdir "$output_directory"
fi

# Check if the special file already exists
if [[ -f $special_file ]]; then
    is_append=true
fi

# Extract lines containing "special" from the input file
# If the special file exists, append to it; otherwise, create a new file
if [[ $is_append == true ]]; then
    grep "special" "$text_file" >>"$special_file"
else
    grep "special" "$text_file" >"$special_file"
fi
