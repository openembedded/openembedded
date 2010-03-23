DESCRIPTION = "Various tools relating to the Simple Network Management Protocol"
HOMEPAGE = "http://www.net-snmp.org/"
LICENSE = "BSD"
DEPENDS = "openssl"
RDEPENDS_${PN}-server += "net-snmp-mibs"
RDEPENDS_${PN}-client += "net-snmp-mibs"
RDEPENDS_${PN}-dev = "net-snmp-client (= ${EXTENDPV}) net-snmp-server (= ${EXTENDPV})"
RRECOMMENDS_${PN}-dbg = "net-snmp-client (= ${EXTENDPV}) net-snmp-server (= ${EXTENDPV})"
INC_PR = "r5"

inherit autotools update-rc.d siteinfo

TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
        # Additional flag based on target endiness (see siteinfo.bbclass)
        ENDIANESS="${@base_conditional('SITEINFO_ENDIANESS', 'le', '--with-endianness=little', '--with-endianness=big', d)}"
        oenote Determined endianess as: $ENDIANESS
        oe_runconf $ENDIANESS
}

do_install_append() {
        install -d ${D}${sysconfdir}/snmp
        install -d ${D}${sysconfdir}/init.d
        install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/snmpd
        install -m 644 ${WORKDIR}/snmpd.conf ${D}${sysconfdir}/snmp/
        install -m 644 ${WORKDIR}/snmptrapd.conf ${D}${sysconfdir}/snmp/
}

do_stage() {
	    rm -rf ${STAGE_TEMP}
	    mkdir -p ${STAGE_TEMP}
	    oe_runmake INSTALL_PREFIX="${STAGE_TEMP}" install
	    autotools_stage_dir ${STAGE_TEMP}/${includedir} ${STAGING_INCDIR}
	    if [ -d ${STAGE_TEMP}/${libdir} ]
	    then
    		olddir=`pwd`
    		cd ${STAGE_TEMP}/${libdir}
    		las=$(find . -name \*.la -type f)
    		cd $olddir
    		echo "Found la files: $las"		 
    		for i in $las
    		do
    			sed -e 's/^installed=yes$/installed=no/' \
    			    -e '/^dependency_libs=/s,${WORKDIR}[[:alnum:]/\._+-]*/\([[:alnum:]\._+-]*\),${STAGING_LIBDIR}/\1,g' \
    			    -e "/^dependency_libs=/s,\([[:space:]']\)${libdir},\1${STAGING_LIBDIR},g" \
    			    -i ${STAGE_TEMP}/${libdir}/$i
    		done
    		autotools_stage_dir ${STAGE_TEMP}/${libdir} ${STAGING_LIBDIR}
    	fi
        install -d ${STAGING_DIR_HOST}${layout_bindir}
        sed -e "s@-I/usr/include@@g" \
            -e "s@^prefix=.*@prefix=${STAGING_DIR_HOST}@g" \
            -e "s@^exec_prefix=.*@exec_prefix=${STAGING_DIR_HOST}@g" \
            -e "s@^includedir=.*@includedir=${STAGING_INCDIR}@g" \
            -e "s@^libdir=.*@libdir=${STAGING_LIBDIR}@g" \
                -i net-snmp-config

        install -m 755 net-snmp-config ${STAGING_DIR_HOST}${layout_bindir}
        rm -Rf ${STAGE_TEMP}
}

PACKAGES = "net-snmp-dbg net-snmp-doc net-snmp-dev net-snmp-libs \
            net-snmp-mibs net-snmp-server net-snmp-client"

FILES_${PN}-libs = "${libdir}/*"
FILES_${PN}-mibs = "${datadir}/snmp/mibs"
FILES_${PN}-server = "${sbindir}/* ${sysconfdir}"
FILES_${PN}-client = "${bindir}/* ${datadir}/snmp/"
FILES_${PN}-dbg += "${libdir}/.debug/ ${sbindir}/.debug/ ${bindir}/.debug/"
FILES_${PN}-dev += ${bindir}/net-snmp-config ${bindir}/mib2c ${bindir}/mib2c-update"

CONFFILES_${PN}-server = "${sysconfdir}/snmp/snmpd.conf \
                          ${sysconfdir}/snmp/snmptrapd.conf"

INITSCRIPT_PACKAGES = "${PN}-server"
INITSCRIPT_NAME_${PN}-server = "snmpd"
INITSCRIPT_PARAMS_${PN}-server = "defaults"

LEAD_SONAME = "libnetsnmp.so"

pkg_postinst_net-snmp-server() {
if test "x$D" != "x"; then
	D="-r $D"
else
	D="-s"
fi
update-rc.d $D snmpd defaults
}

pkg_postrm_net-snmp-server() {
if test "x$D" != "x"; then
	D="-r $D"
else
	/etc/init.d/snmpd stop
fi
update-rc.d $D snmpd remove
}

