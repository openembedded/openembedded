#!/bin/sh

bootdir=`dirname $boot_file`

files="mysql.txt xorg.conf"

mkdir /var/lib/config
cd /var/lib/config

for fn in $files; do
  if ! tftp -g $serverid -r $bootdir/mythfront/$ip/$fn -l $fn; then
    if ! tftp -g $serverid -r $bootdir/mythfront/default/$fn -l $fn; then
      rm -f $fn
    fi
  fi
done
