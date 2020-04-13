#!/bin/bash

CPVER=$(python3 --version 2>&1 | awk '{print $2}')
RPV=3.6.8

echo Current Python version is: $CPVER
echo Required Python version is: $RPV

if awk 'BEGIN{exit ARGV[1]<ARGV[2]}' "$RPV" "$CPVER"
then
 wget https://www.python.org/ftp/python/3.6.9/Python-3.6.9.tgz
 tar xvf Python-3.6.9.tgz
 cd Python-3.6.9
 echo Current directory is:: $PWD
 ./configure --with-zlib 
 make -j8
 sudo make altinstall
else
  echo No python update required
fi