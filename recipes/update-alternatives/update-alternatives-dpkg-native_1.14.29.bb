require update-alternatives-dpkg.inc
inherit native

PR="r1"
PROVIDES += "virtual/update-alternatives-native"
DEPENDS = "perl-native"
DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://update-alternatives-native.patch"

do_stage () {
    install -d ${sbindir} \
               ${localstatedir}/lib/dpkg/alternatives \
               ${sysconfdir}/alternatives

    install -m 0755 scripts/update-alternatives ${sbindir}/update-alternatives
}

SRC_URI[md5sum] = "4326172a959b5b6484b4bc126e9f628d"
SRC_URI[sha256sum] = "ea7ec1c861af43ba534a0d7997774a5f1fd4e25a7eea4ff229c9c7bf89aed633"
