require linux.inc

DEFAULT_PREFERENCE_at91sam9263ek = "20"
DEFAULT_PREFERENCE_at91sam9261ek = "20"
DEFAULT_PREFERENCE_at91sam9260ek = "20"

PR = "r8"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_n2100 = "\
	   file://n2100-r8169-parity.patch;patch=1 \
	   file://rtc-rs5c372-n2100.patch;patch=1 \
	   "

SRC_URI_append_at91sam9263ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1 \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1 \
                               "
SRC_URI_append_at91sam9261ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1 \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1 \
                               "
SRC_URI_append_at91sam9260ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1 \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1 \
                               "


