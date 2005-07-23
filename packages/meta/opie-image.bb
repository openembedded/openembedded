export IMAGE_BASENAME = "opie-image"
export IMAGE_LINGUAS = ""
 
FEED_URIS_append_openzaurus = " opie##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/opie"
FEED_URIS_append_opensimpad = " opie##http://openzaurus.org/official/unstable/${DISTRO_VERSION}/feed/opie"
FEED_URIS_append_familiar   = " opie##http://familiar.handhelds.org/releases/${DISTRO_VERSION}/feed/opie"

LICENSE = "MIT"
PR = "r15"

include opie-collections.inc

#
# Putting it altogether. Better state IPKG_INSTALL and DEPENDS twice, because library names != package names.
#

export IPKG_INSTALL = "task-bootstrap ${OPIE_LIBS_RDEPENDS} ${OPIE_BASE} ${OPIE_BASE_APPLETS} \
                       ${OPIE_BASE_SETTINGS} ${OPIE_BASE_APPS} ${OPIE_BASE_RDEPENDS} \
                       ${OPIE_PIM} ${OPIE_EXTRA_APPLETS} ${OPIE_EXTRA_SETTINGS} \
                       ${OPIE_EXTRA_APPS} ${OPIE_BASE_STYLES} ${OPIE_BASE_DECOS} \
                       ${OPIE_BASE_INPUTMETHODS} ${OPIE_MORE_RDEPENDS}"
 
DEPENDS = "task-bootstrap ${OPIE_LIBS_DEPENDS} ${OPIE_BASE} ${OPIE_BASE_APPLETS} \
            ${OPIE_BASE_SETTINGS}  ${OPIE_BASE_APPS} ${OPIE_BASE_DEPENDS} ${OPIE_PIM} \
            ${OPIE_EXTRA_APPLETS} ${OPIE_EXTRA_SETTINGS} ${OPIE_EXTRA_APPS} \
            ${OPIE_BASE_STYLES} ${OPIE_BASE_DECOS} ${OPIE_BASE_INPUTMETHODS} ${OPIE_MORE_DEPENDS}"



# merge feed-sources into ipkg.conf for opie-aqpkg as it can't handle feed-sources outside of ipkg.conf.
merge_feeds() {

	if ! test -z "${FEED_URIS}"
	then
		# Die gracefully if ipkg-collateral failed
		if ! test -e "${IMAGE_ROOTFS}/etc/ipkg.conf"
		then
			echo "[${IMAGE_ROOTFS}/etc/ipkg.conf] is missing!"
			exit 1
		fi
		
		# comment out existing feed-sources inserted by ipkg-collateral
		cat ${IMAGE_ROOTFS}/etc/ipkg.conf | sed "s/^src\ /#src\ /" > ${IMAGE_ROOTFS}/etc/ipkg.conf_
		rm ${IMAGE_ROOTFS}/etc/ipkg.conf && mv ${IMAGE_ROOTFS}/etc/ipkg.conf_ ${IMAGE_ROOTFS}/etc/ipkg.conf
		
		# extract, then delete destinations
		cat ${IMAGE_ROOTFS}/etc/ipkg.conf | egrep "^dest\ " > ${IMAGE_ROOTFS}/etc/ipkg.conf.dest
		cat ${IMAGE_ROOTFS}/etc/ipkg.conf | egrep -v "^dest\ " > ${IMAGE_ROOTFS}/etc/ipkg.conf_
		rm ${IMAGE_ROOTFS}/etc/ipkg.conf && mv ${IMAGE_ROOTFS}/etc/ipkg.conf_ ${IMAGE_ROOTFS}/etc/ipkg.conf


		for line in ${FEED_URIS}
		do
			# strip leading and trailing spaces/tabs, then split into name and uri
			line_clean="`echo "$line"|sed 's/^[ \t]*//;s/[ \t]*$//'`"
			feed_name="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\1/p'`"
			feed_uri="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\2/p'`"		

			# insert new feed-sources
			echo "src/gz $feed_name $feed_uri" >> ${IMAGE_ROOTFS}/etc/ipkg.conf
		done
		
		# remove temporary files and rebuild ipkg.conf
		echo "" >> ${IMAGE_ROOTFS}/etc/ipkg.conf
		cat ${IMAGE_ROOTFS}/etc/ipkg.conf.dest >> ${IMAGE_ROOTFS}/etc/ipkg.conf
		rm ${IMAGE_ROOTFS}/etc/ipkg.conf.dest
		
		# remove -feed.conf files which are no longer needed
		cd ${IMAGE_ROOTFS}/etc/ipkg/ && rm -- *-feed.conf				
	fi
}


# merge feed-sources into ipkg.conf and create /etc/timestamp from build date
IMAGE_PREPROCESS_COMMAND = "merge_feeds; create_etc_timestamp"

inherit image_ipk
