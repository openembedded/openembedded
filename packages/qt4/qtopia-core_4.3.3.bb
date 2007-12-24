QT_CONFIG_FLAGS += " \
    -nomake demos -nomake examples -nomake tools \
    -qt-mouse-tslib -qt-gfx-transformed -embedded ${QT_ARCH}"

do_stage_append() {
    echo "Fixing up Qt"
    cd ${STAGING_LIBDIR}/pkgconfig
    sed -i s#"-L${S}/lib"##g Qt*.pc
    sed -i s#"moc_location=${S}/bin/moc"#moc_location=${STAGING_BINDIR}/moc4# Qt*.pc
    sed -i s#"uic_location=${S}/bin/uic"#uic_location=${STAGING_BINDIR}/uic4# Qt*.pc
}

do_install() {
    oe_runmake install INSTALL_ROOT=${D}

    # These are host binaries, we should only use them in staging
    rm -rf ${D}/${bindir}
    rm -rf ${D}/${datadir}/mkspecs
        
    touch ${D}/${libdir}/fonts/fontdir
}



STAGE_TEMP = "${WORKDIR}/temp-staging"
do_stage() {
    rm -rf ${STAGE_TEMP}
    mkdir -p ${STAGE_TEMP}
    oe_runmake install INSTALL_ROOT=${STAGE_TEMP}

    install -d ${STAGING_INCDIR}/qtopiacore4
    install -d ${STAGING_LIBDIR}/qtopiacore4
    cp -pPRf ${STAGE_TEMP}/$includedir/* ${STAGING_INCDIR}/qtopiacore4/

    for i in ${STAGE_TEMP}/${libdir}/*.la
    do
        oe_libinstall -C ${STAGE_TEMP}/${libdir} -so $(basename $i .la) ${STAGING_LIBDIR}/qtopiacore4
    done

    rm -rf ${STAGE_TEMP}
}

require qtopia-core.inc
