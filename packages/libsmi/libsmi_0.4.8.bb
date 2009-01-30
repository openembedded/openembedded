DESCRIPTION = "A Library to Access SMI MIB Information"
LICENSE = "BSD"
SRC_URI = "ftp://ftp.ibr.cs.tu-bs.de/pub/local/libsmi/libsmi-0.4.8.tar.gz"
PR = "r1"

inherit autotools

PACKAGES += "${PN}-mibs ${PN}-pibs"
FILES_${PN}-mibs += "${datadir}/mibs"
FILES_${PN}-pibs += "${datadir}/pibs"

do_stage() {
      autotools_stage_all
}

