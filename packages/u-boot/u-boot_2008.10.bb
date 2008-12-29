require u-boot.inc

DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_at91rm9200dk	 = "1"
DEFAULT_PREFERENCE_at91sam9rlek	 = "1"
DEFAULT_PREFERENCE_at91sam9260ek = "1"
DEFAULT_PREFERENCE_at91sam9261ek = "1"
DEFAULT_PREFERENCE_at91sam9g20ek = "1"
DEFAULT_PREFERENCE_at91sam9263ek = "1"
DEFAULT_PREFERENCE_at91cap9adk	 = "1"
DEFAULT_PREFERENCE_atngw100	 = "1"
DEFAULT_PREFERENCE_atstk1000	 = "1"

PR = "r0"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
	   file://u-boot-2008.10-exp-at91sam9g20ek.patch;patch=1 \
	   file://u-boot-2008.10-exp-config.patch;patch=1 \
	   file://u-boot-2008.10-exp-drivers-net-macb.c.patch;patch=1 \
           "

PACKAGE_ARCH = "${MACHINE_ARCH}"
