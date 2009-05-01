# This describes a generic SlugOS image, even though the bb file is
# called 'slugos-image.bb' the distro specific configuration is
# done in conf/distro/${DISTRO}.conf (which should always include
# conf/distro/slugos.conf to get the standard settings).

DESCRIPTION = "Generic SlugOS image"

PR = "r1"

require slugos-image.inc

inherit nslu2-image
