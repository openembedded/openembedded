#!/bin/sh

if [ -d "$2" ] ; then
  echo -e "\ncd $2"
  cd "$2"

  for i in `find . -name '*.' -maxdepth 1` ; do
    echo "bogofilter -d /opt/var/spool/bogofilter -t -v $1 < $i"
    bogofilter -d /opt/var/spool/bogofilter -t -v "$1" < "$i"
  done
fi

