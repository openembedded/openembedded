#!/bin/sh

. /etc/default/fbset
[ -n "$FBSET_MODE" ] && fbset -n $FBSET_MODE
