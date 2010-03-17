DESCRIPTION = "Standard Gtk+ icon theme for the Openmoko framework, QVGA edition"
SECTION = "openmoko/base"
DEPENDS = "imagemagick-native librsvg-native"
SRCREV = "4232"
PV = "0.1.0+svnr${SRCPV}"
PR = "r2"

EXCLUDE_FROM_WORLD = "1"

inherit openmoko2

SRC_URI = "svn://svn.openmoko.org/trunk/src/target/OM-2007.2/artwork/;module=icons;proto=http"
S = "${WORKDIR}/icons"

pkg_postinst_${PN} () {
    if [ "x$D" != "x" ]; then
        exit 1
    fi
    gtk-update-icon-cache -q /usr/share/icons/openmoko-standard
}

do_configure_prepend () {
	cd ${S}
	#
	# don't include 36x36 and 128x128 icons, 32x32 and 48x48 stock icons
	#
	sed -i -e "/\(36\|128\)/d" -e "/\(32\|48\)\/stock/d" configure.ac
	cd openmoko-standard
	sed -i -e "s/\(36x36\|128x128\) //g" Makefile.am
	sed -i "/^SUBDIRS=/s/ stock//" {32x32,48x48}/Makefile.am 
	#
	# rescale stock icons to 22x22
	#
	for png in $(ls */stock/*.png | sed "s,.*/,," | sort | uniq); do
		svg=scalable/stock/$(basename $png .png).svg
		out=22x22/stock/$png
		if [ -f $svg ]; then
			#
			# if there are vector graphics, rerender
			#
			rsvg -w 22 -h 22 $svg $out
		else
			#
			# otherwise rescale biggest existing bitmap
			#
			png=$(echo */stock/$png | sed "s/.* //")
			convert -scale 22x22 $png $out
		fi
	done
	#
	# register the rescaled icons with automake
	#
	cd 22x22/stock
	sed -i "/^icons_DATA/s/=.*/= $(echo *.png)/" Makefile.am
	cd ${S}
}

PACKAGE_ARCH = "all"
