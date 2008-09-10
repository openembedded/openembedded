DESCRIPTION = "MokoGateway: Tasks for a companion server for the Openmoko Linux Distribution"
LICENSE = "MIT"
PROVIDES = "task-mokogateway-everything"
PR = "r5"

inherit task

PACKAGES = "\
	task-mokogateway-everything \
	${MOKOGATEWAY_PACKAGES} \
"

MOKOGATEWAY_PACKAGES = "\
	task-mokogateway-usbnet \
	task-mokogateway-bluetooth \
	task-mokogateway-wifi \
	task-mokogateway-debug \
"

RDEPENDS_task-mokogateway-everything = "${MOKOGATEWAY_PACKAGES}"

DESCRIPTION_task-mokogateway-usbnet = "MokoGateway: USB Networking"
RDEPENDS_task-mokogateway-usbnet = "\
	iptables \
"
RRECOMMENDS_task-mokogateway-usbnet = "\
	kernel-module-usbnet \
	kernel-module-cdc-acm \
	kernel-module-cdc-ether \
	kernel-module-iptable-nat \
	kernel-module-ipt-masquerade \
"

DESCRIPTION_task-mokogateway-bluetooth = "MokoGateway: Bluetooth"
RDEPENDS_task-mokogateway-bluetooth = "\
	bluez-utils \
"
RRECOMMENDS_task-mokogateway-bluetooth = "\
	kernel-module-bluetooth \
	kernel-module-l2cap \
	kernel-module-rfcomm \
	kernel-module-hci-vhci \
	kernel-module-bnep \
	kernel-module-hidp \
	kernel-module-hci-uart \
	kernel-module-sco \
	${@base_contains("COMBINED_FEATURES", "usbhost", "kernel-module-hci-usb", "",d)} \
	${@base_contains("COMBINED_FEATURES", "pcmcia",  "kernel-module-bluetooth3c-cs", "",d)} \
	${@base_contains("COMBINED_FEATURES", "pcmcia",  "kernel-module-bluecard-cs", "",d)} \
	${@base_contains("COMBINED_FEATURES", "pcmcia",  "kernel-module-bluetoothuart-cs", "",d)} \
	${@base_contains("COMBINED_FEATURES", "pcmcia",  "kernel-module-dtl1-cs", "",d)} \
"

DESCRIPTION_task-mokogateway-wifi = "MokoGateway: WiFi"
RDEPENDS_task-mokogateway-wifi = "\
	bridge-utils \
	wireless-tools \
	${@base_contains("COMBINED_FEATURES", "pci", "madwifi-ng-modules", "",d)} \
	${@base_contains("COMBINED_FEATURES", "pci", "madwifi-ng-tools", "",d)} \
	wpa-supplicant \
"
RRECOMMENDS_task-mokogateway-wifi = "\
	kernel-module-ieee80211-crypt \
	kernel-module-ieee80211-crypt-ccmp \
	kernel-module-ieee80211-crypt-tkip \
	kernel-module-ieee80211-crypt-wep \
	kernel-module-arc4 \
	kernel-module-michael-mic \
	kernel-module-aes \
	${@base_contains("COMBINED_FEATURES", "usbhost", "kernel-module-zd1211rw", "",d)} \
	${@base_contains("COMBINED_FEATURES", "usbhost", "zd1211-firmware", "",d)} \
"

DESCRIPTION_task-mokogateway-debug = "MokoGateway: Debug"
RDEPENDS_task-mokogateway-debug = "\
"
# The following packages are broken -- victims of libusb confusion.
# These packages depend upon libusb, which provides libusb.a -- however
# everything else depends upon libusb-compat, which also provides libusb.a
# (this includes bluez-*, usbutils-*, hal-*, libhal-*, etc).  The wrong
# libusb.a is staged for at least somebody.  The hacky solution right now
# is to not build these two utils, as they are the only ones in common use
# that DEPEND upon libusb.  This needs to be fixed in a better way, but this
# will, at least, get the feeds working again.
#	dfu-util \
#	openocd \
RRECOMMENDS_task-mokogateway-debug = "\
"
