#!/bin/sh

# This script is used for loading modules required by SlugOS
# This script may not be necessary if udev is present, but is included
# for 'backup' purposes in case udev is playing silly buggers

. /etc/default/modulefunctions # Load module loading logic

loadnetmods

loaddiskmods

loadmiscmods

exit 0
