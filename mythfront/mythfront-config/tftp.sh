#!/bin/sh

case $1 in
  renew|bound)
  	;;
  *)
  	exit 0
	;;
esac

bootdir=`dirname $boot_file`

files="mysql.txt lircrc mythfront.config"

mkdir /var/lib/config
cd /var/lib/config

for fn in $files; do
  if ! tftp -g $serverid -r $bootdir/mythfront/$ip/$fn -l $fn; then
    if ! tftp -g $serverid -r $bootdir/mythfront/default/$fn -l $fn; then
      rm -f $fn
    fi
  fi
done

if [ -f ./mythfront.config ]; then
  . ./mythfront.config
  if [ "x$REMOTE" != "x" ]; then
    fn=`find /usr/share/lirc/remotes -name lircd.conf.$REMOTE`
    if [ "x$fn" != "x" ]; then
      rm -f lircd.conf
      ln -sf $fn lircd.conf
    fi
  fi
fi

