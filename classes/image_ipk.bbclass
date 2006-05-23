inherit rootfs_ipk

# Images are generally built explicitly, do not need to be part of world.
EXCLUDE_FROM_WORLD = "1"

USE_DEVFS ?= "0"

DEPENDS += "makedevs-native"

def get_image_deps(d):
	import bb
	str = ""
	for type in (bb.data.getVar('IMAGE_FSTYPES', d, 1) or "").split():
		deps = bb.data.getVar('IMAGE_DEPENDS_%s' % type, d) or ""
		if deps:
			str += " %s" % deps
	return str

DEPENDS += "${@get_image_deps(d)}"

IMAGE_DEVICE_TABLE ?= "${@bb.which(bb.data.getVar('BBPATH', d, 1), 'files/device_table-minimal.txt')}"
IMAGE_POSTPROCESS_COMMAND ?= ""

# Must call real_do_rootfs() from inside here, rather than as a separate
# task, so that we have a single fakeroot context for the whole process.
fakeroot do_rootfs () {
	set -x
	rm -rf ${IMAGE_ROOTFS}

	if [ "${USE_DEVFS}" != "1" ]; then
		mkdir -p ${IMAGE_ROOTFS}/dev
		makedevs -r ${IMAGE_ROOTFS} -D ${IMAGE_DEVICE_TABLE}
	fi

	real_do_rootfs

	insert_feed_uris	

	rm -f ${IMAGE_ROOTFS}${libdir}/ipkg/lists/oe
	
	${IMAGE_PREPROCESS_COMMAND}
		
	export TOPDIR=${TOPDIR}

	for type in ${IMAGE_FSTYPES}; do
		if test -z "$FAKEROOTKEY"; then
			fakeroot -i ${TMPDIR}/fakedb.image bbimage -t $type -e ${FILE}
		else
			bbimage -n "${IMAGE_NAME}" -t "$type" -e "${FILE}"
		fi
	done

	${IMAGE_POSTPROCESS_COMMAND}
}

DISTRO_LOCALE_FEEDS_PREFIXES ?= ""
DISTRO_LOCALE_FEEDS_HEADER ?= ""

python __anonymous() {
	prefixes = bb.data.getVar("DISTRO_LOCALE_FEEDS_PREFIXES", d, 1).split()
	locale_feeds = bb.data.getVar("DISTRO_LOCALE_FEEDS_HEADER", d, 1)

	# add template
	locale_feeds += "# For each supported locale there is a subfeed in each of the feed folders.\n"
	locale_feeds += "# You can use your webbrowser to check for valid locale codes.\n\n"
	locale_feeds += "# To point ipkg at packages for your locale, replace <my_locale> with the\n"
	locale_feeds += "# locale code in the template below and remove the leading '#' characters.\n\n"
	for p in prefixes:
		locale_feeds += "# src/gz %s-locale-<my_locale> %s/locale/<my_locale>\n" % (p.split('/')[-1], p)
	
	# add feed for each IMAGE_LINGUA
	linguas = bb.data.getVar("IMAGE_LINGUAS", d, 1).split()
	for l in linguas:
		fst = l.split('-')[0]
		locale_feeds += "\n# %s locale feeds\n" % fst
		for p in prefixes:
			locale_feeds += "src/gz %s-locale-%s %s/locale/%s\n" % (p.split('/')[-1], fst, p, fst)
	
	bb.data.setVar("DISTRO_LOCALE_FEEDS", locale_feeds, d)
}

insert_feed_uris () {
	
	echo "Building feeds for [${DISTRO}].."
		
	for line in ${FEED_URIS}
	do
		# strip leading and trailing spaces/tabs, then split into name and uri
		line_clean="`echo "$line"|sed 's/^[ \t]*//;s/[ \t]*$//'`"
		feed_name="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\1/p'`"
		feed_uri="`echo "$line_clean" | sed -n 's/\(.*\)##\(.*\)/\2/p'`"					
		
		echo "Added $feed_name feed with URL $feed_uri"
		
		# insert new feed-sources
		echo "src/gz $feed_name $feed_uri" >> ${IMAGE_ROOTFS}/etc/ipkg/${feed_name}-feed.conf
	done			

	if [ -z ${FEED_URIS} ]; then
cat > ${IMAGE_ROOTFS}/etc/ipkg/${DISTRO}-${DISTRO_VERSION}-feeds.conf <<EOF
${DISTRO_FEEDS}
EOF

cat > ${IMAGE_ROOTFS}/etc/ipkg/${DISTRO}-${DISTRO_VERSION}-locale-feeds.conf <<EOF
${DISTRO_LOCALE_FEEDS}
EOF
	fi
}
