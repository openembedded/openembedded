require evas.inc
inherit native
DEPENDS = "freetype-native libxext-native libpng-native jpeg-native eet-native eina-native libfribidi-native"
PR = "r2"

EXTRA_OECONF = "\
		--x-includes=${STAGING_INCDIR}/X11  \
		--x-libraries=${STAGING_LIBDIR} \
		--enable-evas-magic-debug \
		\
		--enable-fb				\
		--disable-directfb			\
		--disable-sdl				\
		--enable-buffer				\
		--disable-software-ddraw	\
		--disable-software-qtopia	\
		--disable-software-x11		\
		--disable-software-16-x11	\
		--disable-software-xcb		\
		--disable-gl-x11			\
		--disable-xrender-x11		\
		--disable-xrender-xcb		\
		--disable-glitz-x11			\
		--enable-image-loader-eet	\
		--disable-image-loader-edb	\
		--disable-image-loader-gif	\
		--enable-image-loader-png	\
		--enable-image-loader-jpeg	\
		--enable-image-loader-tiff	\
		--enable-image-loader-xpm	\
		--disable-image-loader-svg	\
		--enable-cpu-c				\
		--enable-fontconfig			\
		--enable-font-loader-eet	\
		--enable-scale-sample		\
		--enable-scale-smooth		\
		--enable-convert-yuv		\
		--enable-small-dither-mask	\
		--disable-no-dither-mask	\
		--disable-convert-8-rgb-332	\
		--disable-convert-8-rgb-666	\
		--disable-convert-8-rgb-232	\
		--disable-convert-8-rgb-222	\
		--disable-convert-8-rgb-221	\
		--disable-convert-8-rgb-121	\
		--disable-convert-8-rgb-111	\
		--enable-convert-16-rgb-565	\
		--disable-convert-16-rgb-555	\
		--disable-convert-16-rgb-444	\
		--disable-convert-16-rgb-ipq	\
		--enable-convert-16-rgb-rot-0	\
		--disable-convert-16-rgb-rot-90	\
		--enable-convert-16-rgb-rot-270	\
		--disable-convert-24-rgb-888	\
		--disable-convert-24-bgr-888	\
		--disable-convert-32-rgb-8888	\
		--disable-convert-32-rgbx-8888	\
		--disable-convert-32-bgr-8888	\
		--disable-convert-32-bgrx-8888	\
		--disable-convert-32-rgb-rot-0	\
		--disable-convert-32-rgb-rot-90	\
		--disable-convert-32-rgb-rot-270"


# evas needs a different oe_libinstall, so copy/paste autotools_stage_all
do_oldstage() {
        rm -rf ${STAGE_TEMP}
        mkdir -p ${STAGE_TEMP}
        oe_runmake DESTDIR="${STAGE_TEMP}" install
        autotools_stage_dir ${STAGE_TEMP}/${includedir} ${STAGING_INCDIR}
        if [ "${BUILD_SYS}" = "${HOST_SYS}" ]; then
                autotools_stage_dir ${STAGE_TEMP}/${bindir} ${STAGING_DIR_HOST}${layout_bindir}
                autotools_stage_dir ${STAGE_TEMP}/${sbindir} ${STAGING_DIR_HOST}${layout_sbindir}
                autotools_stage_dir ${STAGE_TEMP}/${base_bindir} ${STAGING_DIR_HOST}${layout_base_bindir}
                autotools_stage_dir ${STAGE_TEMP}/${base_sbindir} ${STAGING_DIR_HOST}${layout_base_sbindir}
                autotools_stage_dir ${STAGE_TEMP}/${libexecdir} ${STAGING_DIR_HOST}${layout_libexecdir}
        fi
        if [ -d ${STAGE_TEMP}/${libdir} ]
        then
                olddir=`pwd`
                cd ${STAGE_TEMP}/${libdir}
                las=$(find . -name \*.la -type f)
                cd $olddir
                echo "Found la files: $las"
                if [ -n "$las" ]; then
                        # If there are .la files then libtool was used in the
                        # build, so install them with magic mangling.
                        for i in $las
                        do
                                dir=$(dirname $i)
                                echo "oe_libinstall -C ${STAGE_TEMP}/${libdir}/${dir} -so $(basename $i .la) ${STAGING_LIBDIR}/${dir}"
                                oe_libinstall -C ${STAGE_TEMP}/${libdir}/${dir} -so $(basename $i .la) ${STAGING_LIBDIR}/${dir}
                        done
                else
                        # Otherwise libtool wasn't used, and lib/ can be copied
                        # directly.
                        echo "cp -fpPR ${STAGE_TEMP}/${libdir}/* ${STAGING_LIBDIR}"
                        cp -fpPR ${STAGE_TEMP}/${libdir}/* ${STAGING_LIBDIR}
                fi

        fi
        # Ok, this is nasty. pkgconfig.bbclass is usually used to install .pc files,
        # however some packages rely on the presence of .pc files to enable/disable
        # their configurataions in which case we better should not install everything
        # unconditionally, but rather depend on the actual results of make install.
        # The good news though: a) there are not many packages doing this and
        # b) packaged staging will fix that anyways. :M:
        if [ "${AUTOTOOLS_STAGE_PKGCONFIG}" = "1" ]
        then
                echo "cp -f ${STAGE_TEMP}/${libdir}/pkgconfig/*.pc ${STAGING_LIBDIR}/pkgconfig/"
                cp -f ${STAGE_TEMP}/${libdir}/pkgconfig/*.pc ${STAGING_LIBDIR}/pkgconfig/
        fi
        rm -rf ${STAGE_TEMP}/${mandir} || true
        rm -rf ${STAGE_TEMP}/${infodir} || true
        autotools_stage_dir ${STAGE_TEMP}/${datadir} ${STAGING_DATADIR}
        rm -rf ${STAGE_TEMP}

}
