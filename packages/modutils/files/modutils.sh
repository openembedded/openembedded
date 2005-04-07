#!/bin/sh

[ -f /proc/modules ] || exit 0
[ -e /sbin/depmod ] || exit 0
[ -f /etc/modules ] || exit 0

[ "$VERBOSE" != no ] && echo "Calculating module dependencies ..."
depmod -Ae

[ "$VERBOSE" != no ] && echo -n "Loading modules: "
(cat /etc/modules; echo; ) |
while read module args
do
	case "$module" in
		\#*|"") continue ;;
	esac
	[ "$VERBOSE" != no ] && echo -n "$module "
	modprobe $module $args >/dev/null 2>&1
done
[ "$VERBOSE" != no ] && echo

exit 0
