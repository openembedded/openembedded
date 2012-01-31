require bluez4.inc

SRC_URI = "\
  ${KERNELORG_MIRROR}/pub/linux/bluetooth/bluez-${PV}.tar.gz \
  file://bluetooth.conf \
"
SRC_URI[md5sum] = "362864b716950baa04797de735fc237b"
SRC_URI[sha256sum] = "9a5b655bada7c7a1921cb3bac83b8a32bbe49893e4c7a1377cdc1b0d35f7d233"

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
