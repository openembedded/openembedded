SECTION = "gpe"
RDEPENDS += "gdk-pixbuf-loader-png"

INHERIT = "gpe"
INHERIT_shr = "gpe update-alternatives"
inherit ${INHERIT}

INC_PR = "r4"

ALTERNATIVE_NAME = "gpe-pixmaps"
ALTERNATIVE_LINK = "${datadir}/gpe/pixmaps"
ALTERNATIVE_PATH = "${datadir}/gpe/pixmaps.${PN}"
ALTERNATIVE_PRIORITY ?= 1

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
}
