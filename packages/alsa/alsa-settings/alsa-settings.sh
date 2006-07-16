#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2006
# License: GPL (see http://www.gnu.org/licenses/gpl.txt for a copy of the license)
#
# Filename: alsa-settings.sh
# Date: 16-Jul-06

if ! test -e /etc/asound.state
then
	echo "Installing ALSA default settings"
	cp /usr/share/alsa/asound.state.default /etc/asound.state
fi

if test -e /etc/asound.state -a -x /usr/sbin/alsactl
then
	echo "Restoring ALSA settings"
	/usr/sbin/alsactl restore
fi
