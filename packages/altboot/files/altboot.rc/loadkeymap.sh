#!/bin/sh

# Note: With kernel 2.6 the standard keymap is unusable
test -x /etc/init.d/keymap && /etc/init.d/keymap start >/dev/null 2>&1

