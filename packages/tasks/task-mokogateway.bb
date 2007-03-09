DESCRIPTION = "MokoGateway: Tasks for a companion server for the OpenMoko Linux Distribution"
ALLOW_EMPTY = "1"
PACKAGE_ARCH = "all"
LICENSE = "MIT"
PROVIDES = "task-mokogateway-everything"
PR = "1"

PACKAGES = "\
	task-mokogateway-everything \
	${MOKOGATEWAY_PACKAGES} \
"

MOKOGATEWAY_PACKAGES = "\
	task-mokogateway-usbnet \
	task-mokogateway-bluetooth \
	task-mokogateway-wifi \
"

RDEPENDS_task-mokogateway-everything = "${MOKOGATEWAY_PACKAGES}"

DESCRIPTION_task-mokogateway-usbnet = "MokoGateway: USB Networking"
RDEPENDS_task-mokogateway-usbnet = "\
"
RRECOMMENDS_task-mokogateway-usbnet = "\
	kernel-module-usbnet \
	kernel-module-cdc-ether \
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
	wireless-tools \
	${@base_contains("COMBINED_FEATURES", "pcmcia", "hostap-utils", "",d)} \
	${@base_contains("COMBINED_FEATURES", "pci", "hostap-utils", "",d)} \
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

