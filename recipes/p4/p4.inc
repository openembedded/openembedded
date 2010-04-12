# p4 .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

DESCRIPTION = "Perforce client and server binaries"
HOMEPAGE = "http://www.perforce.com"
LICENSE = "Perforce"

def p4_arch(d):
	import bb, re
	arch = bb.data.getVar('TARGET_ARCH', d, 1)
	os = bb.data.getVar('TARGET_OS', d, 1)

	if re.match("^linux.*$", os):
		r = re.compile("([0-9]+\.[0-9]+).*")
		m = r.match(base_read_file(bb.data.expand('${STAGING_KERNEL_DIR}/kernel-abiversion', d)));
		os = "linux"
		if m and re.match("^.*86.*$", arch):
			os = "linux%s" % m.group(1).replace('.','')

	if re.match("^i.86$", arch):
		arch = "x86"
	elif arch == "x86_64":
		arch = "amd64"
	elif re.match("^mips.*$", arch):
		arch = "mips"

	return "%s%s" % (os, arch)

P4ARCH = "${@p4_arch(d)}"
P4BASEURL = "http://filehost.perforce.com/perforce/r${PV}/bin.${P4ARCH}"

#Because these files are all named the same thing, regardless of version or arch
PREMIRRORS=""
DL_DIR="${WORKDIR}/${P4ARCH}"

SRC_URI="\
	${P4BASEURL}/p4;name=p4 \
	${P4BASEURL}/p4api.tar;name=p4api \
	${P4BASEURL}/p4d;name=p4d \
	${P4BASEURL}/p4ftpd;name=p4ftpd \
	${P4BASEURL}/p4p;name=p4p \
	${P4BASEURL}/p4web;name=p4web"
S = "${WORKDIR}"

PACKAGES += " ${PN}-server"
FILES_${PN} = " ${bindir}/p4"
FILES_${PN}-server = " ${bindir}/p4d ${bindir}/p4ftpd ${bindir}/p4p ${bindir}/p4web"

do_stage() {
	install -d ${STAGING_INCDIR}/p4api
	install -m 0644 *.h ${STAGING_INCDIR}/p4api/

	oe_libinstall -a libclient ${STAGING_LIBDIR}
	oe_libinstall -a librpc ${STAGING_LIBDIR}
	oe_libinstall -a libsupp ${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${includedir}/p4api
	install -d ${D}${libdir}

	install -m 0644 *.h ${D}${includedir}/p4api/
	for p4bin in p4 p4d p4ftpd p4p p4web ; do
		install -m 0755 $p4bin ${D}${bindir}/
	done

	oe_libinstall -a libclient ${D}${libdir}/
	oe_libinstall -a librpc ${D}${libdir}/
	oe_libinstall -a libsupp ${D}${libdir}/
}
