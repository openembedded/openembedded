#!/bin/sh

install -d $HOME/.mythtv
ln -sf /var/lib/config/lircrc $HOME/.mythtv/lircrc

exec mythfrontend

