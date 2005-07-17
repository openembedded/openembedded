SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://tmpfs.patch;patch=1 \
	   file://noasmlinkage.patch;patch=1 \
	   file://flags.patch;patch=1 \
	   file://init"

include udev.inc

PR = "r0"

#FIXME a) udevd doesn't start with our init script (the init script seems to be pretty oudated)
#FIXME b) lots of alignment errors when manually starting udevd
DEFAULT_PREFERENCE = "-1"
