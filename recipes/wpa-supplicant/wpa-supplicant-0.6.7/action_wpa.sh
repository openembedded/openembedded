#!/bin/sh

# Action script to enable/disable wpa-roam interfaces in reaction to
# pm-action or ifplugd events.
#
# Copyright: Copyright (c) 2008, Kel Modderman <kel@otaku42.de>
# License:   GPL-2
#

PATH=/sbin:/usr/sbin:/bin:/usr/bin

if [ ! -x /sbin/wpa_action ]; then
	exit 0
fi

SELF=action_wpa
COMMAND=
IFPLUGD_IFACE=

# pm-action(8) - <action> <suspend method>
#
# On suspend|hibernate, disconnect any wpa-roam managed interfaces,
# reconnect it on resume.

case "${1}" in
        suspend|hibernate)
                COMMAND=disconnect
                ;;
        resume|thaw)
                COMMAND=reconnect
                ;;
esac

if [ -z "$COMMAND" ]; then
	# ifplugd(8) - <iface> <action>
	#
	# If an ifplugd managed interface is brought up, disconnect any
	# wpa-roam managed interfaces so that only one "roaming" interface
	# remains active on the system.

	IFPLUGD_IFACE="${1}"

	case "${2}" in
		up)
			COMMAND=disconnect
			;;
		down)
			COMMAND=reconnect
			;;
		*)
			echo "${SELF}: unknown $0 arguments: ${@}" >&2
			exit 1
			;;
        esac
fi

if [ -z "$COMMAND" ]; then
	echo "${SELF}: unknown arguments: ${@}" >&2
	exit 1
fi

for CTRL in /var/run/wpa_supplicant/*; do
	[ -S "${CTRL}" ] || continue

	IFACE="${CTRL#/var/run/wpa_supplicant/}"

	wpa_action "${IFACE}" check || continue

	if [ "${IFPLUGD_IFACE}" ] && [ "${IFPLUGD_IFACE}" = "${IFACE}" ]; then
		# if ifplugd is managing this interface (not likely but..)
		# do nothing
		continue
	fi

	wpa_cli -i "${IFACE}" "${COMMAND}"
done
