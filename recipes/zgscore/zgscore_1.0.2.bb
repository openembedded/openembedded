DESCRIPTION = "Zaurus Golf Score Application for Qt/Embedded based Palmtop Environments"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://nuke.cinlug.org/modules/Static_Docs/data/db/zgs/"
PR = "r0"

SRC_URI = "http://www.cinlug.org/modules/Static_Docs/data/db/zgs/zgscore_${PV}_arm.src.tar.gz \
           file://qtopia17.patch;patch=1"
S = "${WORKDIR}/zgscore-src"

inherit palmtop

EXTRA_QMAKEVARS_POST += 'TMAKE_LIBS-="-luuid" TMAKE_LIBS+="-lqpe" CONFIG+=qt CONFIG-=qtopia'

do_install() {
        install -d ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/Applications \
		   ${D}${palmtopdir}/pics
        install -m 0755 zgscore ${D}${palmtopdir}/bin/zgscore
	install -m 0755 zgscore.png ${D}${palmtopdir}/pics/
	install -m 0644 zgscore.desktop ${D}${palmtopdir}/apps/Applications/
}

SRC_URI[md5sum] = "98e9dd2db54015c0f5193c5427f02d50"
SRC_URI[sha256sum] = "a2683b8a6a172017f0fe6392fb07d87a5c02fc2714fbff4c98dcae67db588636"
