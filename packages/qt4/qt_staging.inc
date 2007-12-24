# Fixing up some Qt .pc files
do_stage_append() {
    cd ${STAGING_LIBDIR}/pkgconfig
    sed -i s#"-L${S}/lib"##g Qt*.pc
    sed -i s#"moc_location=${S}/bin/moc"#moc_location=${STAGING_BINDIR}/moc4# Qt*.pc
    sed -i s#"uic_location=${S}/bin/uic"#uic_location=${STAGING_BINDIR}/uic4# Qt*.pc
}

STAGE_TEMP = "${WORKDIR}/temp-staging"
do_stage() {
    rm -rf ${STAGE_TEMP}
    mkdir -p ${STAGE_TEMP}
    oe_runmake install INSTALL_ROOT=${STAGE_TEMP}

    install -d ${STAGING_INCDIR}/${QT_DIR_NAME}
    install -d ${STAGING_LIBDIR}/${QT_DIR_NAME}
    cp -pPRf ${STAGE_TEMP}/$includedir/* ${STAGING_INCDIR}/${QT_DIR_NAME}/

    for i in ${STAGE_TEMP}/${libdir}/*.la
    do
        oe_libinstall -C ${STAGE_TEMP}/${libdir} -so $(basename $i .la) ${STAGING_LIBDIR}/qtopiacore4
    done

    rm -rf ${STAGE_TEMP}
}
