require bluez4.inc

SRC_URI = "\
  ${KERNELORG_MIRROR}/pub/linux/bluetooth/bluez-${PV}.tar.gz \
  file://bluetooth.conf \
"
SRC_URI[md5sum] = "3e6e77ae06aad73bbedbabed3f0d508e"
SRC_URI[sha256sum] = "795dc8eb45e07c7848c58e2f2d730a404179ecce3dd1cd7b822cdec5ea7b69c8"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

DEPENDS += "libsndfile1"

PR = "${INC_PR}.0"

# Not all distros have a recent enough udev
BTUDEV = " --disable-udevrules"
BTUDEV_angstrom = " --enable-udevrules"
BTUDEV_shr = " --enable-udevrules"

EXTRA_OECONF += "${BTUDEV}"
do_configure_append(){
	echo "#define LIBUDEV_I_KNOW_THE_API_IS_SUBJECT_TO_CHANGE" >> ${S}/config.h
}

FILES_${PN}-dbg += "\
  ${base_libdir}/udev/.debug \
  ${libdir}/*/.debug \
"
