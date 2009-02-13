###########################################
#@MAINTAINER: Marco Cavallini <m.cavallini@koansoftware.com>
# linux_2.6.25.20.bb 
# recipe file for PM9261 and PM9263
###########################################

require linux.inc

PR = "r2"

DEFAULT_PREFERENCE_ronetix-pm9263 = "1"
DEFAULT_PREFERENCE_ronetix-pm9261 = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.25.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.25.20.bz2;patch=1 \
           file://defconfig"

# WARNING: for following patched is required the proper entry in conf/checksums.ini

SRC_URI_append_ronetix-pm9263 = " \
                                 http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1 \
                                 http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/linux-2.6.25.4-ronetix-08-11-02.2228.patch;patch=1 \
                                 http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/socketcan-driver-at91.patch;patch=1 \
                               "

SRC_URI_append_ronetix-pm9261 = " \
                                 http://maxim.org.za/AT91RM9200/2.6/2.6.25-at91.patch.gz;patch=1 \
                                 http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/linux-2.6.25.4-ronetix-08-11-02.2228.patch;patch=1 \
                                 http://download.ronetix.info/sk-eb926x/linux/kernel/2.6.25.4/socketcan-driver-at91.patch;patch=1 \
                               "

S = "${WORKDIR}/linux-2.6.25/"
