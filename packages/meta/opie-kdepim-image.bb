include opie-image.bb

export IMAGE_BASENAME = "opie-kdepim-image"

#
# Putting it altogether. Better state IPKG_INSTALL and DEPENDS twice, because library names != package names.
#

export IPKG_INSTALL = "task-bootstrap ${OPIE_LIBS_RDEPENDS} ${OPIE_BASE} ${OPIE_BASE_APPLETS} \
                       ${OPIE_BASE_SETTINGS} ${OPIE_BASE_APPS} ${OPIE_BASE_RDEPENDS} \
                       ${KDE_PIM_RDEPENDS} ${OPIE_EXTRA_APPLETS} ${OPIE_EXTRA_SETTINGS} \
                       ${OPIE_EXTRA_APPS} ${OPIE_BASE_STYLES} ${OPIE_BASE_DECOS} \
                       ${OPIE_BASE_INPUTMETHODS}"

DEPENDS = "task-bootstrap ${OPIE_LIBS_DEPENDS} ${OPIE_BASE} ${OPIE_BASE_APPLETS} \
            ${OPIE_BASE_SETTINGS}  ${OPIE_BASE_APPS} ${OPIE_BASE_DEPENDS} ${KDE_PIM_DEPENDS} \
            ${OPIE_EXTRA_APPLETS} ${OPIE_EXTRA_SETTINGS} ${OPIE_EXTRA_APPS} \
            ${OPIE_BASE_STYLES} ${OPIE_BASE_DECOS} ${OPIE_BASE_INPUTMETHODS}"
