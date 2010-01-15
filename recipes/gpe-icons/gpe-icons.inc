SECTION = "gpe"
RDEPENDS += "gdk-pixbuf-loader-png"

#only icons present in the package
PACKAGE_ARCH = "all"

INC_PR = "r5"

ALTERNATIVE_NAME = "gpe-pixmaps"
ALTERNATIVE_LINK = "${datadir}/gpe/pixmaps"
ALTERNATIVE_PATH = "${datadir}/gpe/pixmaps.${PN}"
ALTERNATIVE_PRIORITY ?= 1

# copy icons from other alternatives if they are not provided by current alternative
# ie gpe-sketchbook install own icon to pixmaps dir even before gpe-icons_*.bb is installed
# so if we switch pixmaps link to neo theme, there would be no icon for gpe-sketchbook 
# unless we copy it to neo theme in postinst too
# inherit update-alternatives is not used, because not all distributions want to use it 
# and conditional inherit is a bit difficult to use (inherit ${GPE_INHERIT} works, but only if we always want at least 1 bbclass)

pkg_postinst_shr() {
        if [[ -e ${ALTERNATIVE_LINK} && ! -h ${ALTERNATIVE_LINK} ]] ; then
                echo "warn: ${ALTERNATIVE_LINK} exists and it's not a link!"
                echo "warn: It will be replaced with link managed by update-alternatives"
                echo "warn: Moving ${ALTERNATIVE_LINK} to ${ALTERNATIVE_LINK}.old."
                echo "warn: It should be empty but probably isn't!"
                echo "warn: Check what's left there and remove it manually."
                mv -f ${ALTERNATIVE_LINK} ${ALTERNATIVE_LINK}.old
        fi
        pixmap_dirs_root="${datadir}/gpe/"
        cd ${pixmap_dirs_root}
        for pixmap_dir in pixmaps.*; do
                if [ "${pixmap_dir}"x == "pixmaps.${PN}"x ] ; then
                          continue;
                fi
                for pixmap in `find ${pixmap_dir}`; do 
                          pixmap_target=`echo ${pixmap} | sed "s/${pixmap_dir}/pixmaps.${PN}/g"`; 
                          if [ ! -e ${pixmap_target} ] ; then 
                                      cp -ra ${pixmap} ${pixmap_target}; 
                                      echo "${pixmap} merged"; 
                          fi; 
                done
        done
        update-alternatives --install ${ALTERNATIVE_LINK} ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH} ${ALTERNATIVE_PRIORITY}
}

pkg_postrm_shr() {
        update-alternatives --remove ${ALTERNATIVE_NAME} ${ALTERNATIVE_PATH}
}
