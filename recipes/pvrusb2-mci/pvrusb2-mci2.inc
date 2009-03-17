require pvrusb2-mci.inc

export TARGET_LDFLAGS = "-L${STAGING_DIR_TARGET}${layout_libdir} \
                         -Wl,-rpath-link,${STAGING_DIR_TARGET}${layout_libdir}"
