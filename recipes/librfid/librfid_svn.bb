DESCRIPTION = "RFID library"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libusb0"
SRCNAME = "librfid"

PV = "0.2.0+svnr${SRCPV}"
PR = "r5"

SRC_URI = "svn://svn.gnumonks.org/trunk;module=${SRCNAME};proto=http \
           file://010-rc632-definitions-fix.patch;patch=1 \
           file://011-rc632-define-fixes-followups.patch;patch=1 \
           file://012-rc632-error-reg-ro-2.patch;patch=1 \
           file://013-zero-UID.patch;patch=1 \
           file://015-no_segfault.patch;patch=1 \
           file://soos01-set_clear_bits.patch;patch=1 \
           file://soos02-check-errors.patch;patch=1 \
           file://soos03-no_hang-openpcd.patch;patch=1 \
           file://librfid.rules \
          "

SRC_URI_append_boc01 = "file://spidev.patch;patch=1"
PACKAGE_ARCH_boc01 = "boc01"
EXTRA_OECONF_boc01 += "--enable-spidev"

S = "${WORKDIR}/${SRCNAME}"

inherit autotools

do_install_append() {
	install -d ${D}/${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/librfid.rules ${D}/${sysconfdir}/udev/rules.d/70-librfid.rules
}

do_stage() {
	autotools_stage_all
}
