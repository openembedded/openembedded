#!/bin/sh

mkdir -p $HOME/.mythtv
ln -sf /var/lib/config/lircrc $HOME/.mythtv/lircrc
ln -sf /etc/mythtv/mysql.txt $HOME/.mythtv/lircrc

exec mythfrontend

