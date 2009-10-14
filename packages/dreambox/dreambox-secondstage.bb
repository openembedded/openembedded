DESCRIPTION = "Dreambox second stage bootloader"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PV_dm7020 = "35"
PV_dm7025 = "74"
PV_dm600pvr = "66"
PV_dm500plus = "66"
PV_dm8000 = "76"
PV_dm800 = "75"
PV_dm500hd = "70"
PR = "r0"

RDEPENDS_dm8000 = "dreambox-bootlogo (>=5.1-r3)"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.bin"

SECONDSTAGE_UPDATE_SRC = "http://sources.dreamboxupdate.com/download/7020/secondstage-${MACHINE}-${PV}.nfi \
	http://sources.dreamboxupdate.com/download/7020/writenfi-r1"

SRC_URI_append_dm8000 = " ${SECONDSTAGE_UPDATE_SRC}"
SRC_URI_append_dm800 = " ${SECONDSTAGE_UPDATE_SRC}"
#SRC_URI_append_dm500hd = " ${SECONDSTAGE_UPDATE_SRC}"

S = "${WORKDIR}"

do_stage() {
	install -d ${STAGING_LIBDIR}/dreambox-secondstage
	gzip -c ${S}/secondstage-${MACHINE}-${PV}.bin > ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz
}

# the dm{800,8000,500hd} secondstage is already compressed (and encrypted)

do_stage_dm8000() {
	install -d ${STAGING_LIBDIR}/dreambox-secondstage
	cp ${S}/secondstage-${MACHINE}-${PV}.bin ${STAGING_LIBDIR}/dreambox-secondstage/main.bin.gz
}

do_install_dm8000() {
	install -d ${D}/tmp
	install ${WORKDIR}/secondstage-${MACHINE}-${PV}.nfi ${D}/tmp/secondstage.nfi
	install -m 0755 ${WORKDIR}/writenfi-r1 ${D}/tmp/writenfi
}

do_stage_dm800() {
	do_stage_dm8000
}

do_install_dm800() {
	do_install_dm8000
}

do_stage_dm500hd() {
	do_stage_dm8000
}

#do_install_dm500hd() {
#	do_install_dm8000
#}

FILES_${PN} = "/tmp"
PACKAGE_ARCH := "${MACHINE_ARCH}"

pkg_postinst() {
	if [ -d /proc/stb ]; then
		if [ -f /tmp/writenfi ]; then
			/tmp/writenfi /tmp/secondstage.nfi;
			rm /tmp/writenfi /tmp/secondstage.nfi;
		fi
	fi
}
