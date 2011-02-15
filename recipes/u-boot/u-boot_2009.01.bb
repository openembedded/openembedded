require u-boot.inc

PV = "2009.01"

DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_at91rm9200dk	 = "1"
DEFAULT_PREFERENCE_at91sam9rlek	 = "1"
DEFAULT_PREFERENCE_at91sam9260ek = "1"
DEFAULT_PREFERENCE_at91sam9261ek = "1"
DEFAULT_PREFERENCE_at91sam9g20ek = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "1"
DEFAULT_PREFERENCE_at91cap9adk	 = "1"
DEFAULT_PREFERENCE_atngw100	 = "1"
DEFAULT_PREFERENCE_atstk1000	 = "1"

PR = "r2"

SRC_URI = "ftp://ftp.denx.de/pub/u-boot/u-boot-${PV}.tar.bz2 \
	   file://dont-inline-weak-symbols.patch"

SRC_URI_append_at91sam9263ek = "\
	   file://u-boot-2009.01-exp-002-at91sam9g20ek.patch \
	   file://u-boot-2009.01-exp-003-drivers-net-macb.c.patch \
           "

SRC_URI_append_at91sam9g20ek = "\
	   file://u-boot-2009.01-exp-002-at91sam9g20ek.patch \
	   file://u-boot-2009.01-exp-003-drivers-net-macb.c.patch \
           file://at91sam9g20-fix-config.patch \
           "

SRC_URI[md5sum] = "cb11d3d74eee4d31124523d90d8c31fa"
SRC_URI[sha256sum] = "0c0afa2816482e087987f71958b656ff0c122032f5e3897a8d17daca5bc14115"
