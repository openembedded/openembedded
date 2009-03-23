#!/bin/sh

LOAD_MODULE=modprobe
[ -e /sbin/modprobe ] || LOAD_MODULE=insmod

if [ -e /sbin/depmod -a ! -f /lib/modules/`uname -r`/modules.dep ]; then
	[ "$VERBOSE" != no ] && echo "Calculating module dependencies ..."
	depmod -Ae
fi

if [ -f /proc/modules ]; then
       if [ -f /etc/modules ]; then
               [ "$VERBOSE" != no ] && echo -n "Loading modules: "
               while read module args
               do
                       case "$module" in
                               \#*|"") continue ;;
                       esac
                       [ "$VERBOSE" != no ] && echo -n "$module "
                       eval "$LOAD_MODULE $module $args >/dev/null 2>&1"
               done < /etc/modules
               [ "$VERBOSE" != no ] && echo
       fi
fi

: exit 0
