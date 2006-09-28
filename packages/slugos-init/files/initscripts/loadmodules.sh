#!/bin/sh

# This script is used for loading modules required by SlugOS
# Currently, this script only supports the NSLU2

. /etc/default/functions # Load $(machine) function required
. /etc/default/modulefunctions

echo "Loading networking modules"
loadnetmods

echo "Loading usb storage modules"
loadusbmods

echo "Loading other modules"
loadmiscmods

exit 0
