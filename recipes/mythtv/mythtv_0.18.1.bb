require mythtv.inc

inherit qmake2 qt3x11

PR = "r2"

SRC_URI += "file://msmpeg-underscore-pic.patch;patch=1 \
	    file://settings.pro"


do_configure_prepend() {
# it's not autotools anyway, so we call ./configure directly
	find . -name "Makefile"|xargs rm -f
	./configure	--prefix=/usr		\
			--mandir=/usr/man 	\
			--disable-mp3lame	\
			--enable-vorbis 	\
			--disable-faad		\
			--disable-faadbin 	\
			--disable-faac		\
			--disable-mingw32	\
			--enable-a52		\
			--disable-a52bin	\
			--enable-pp		\
			--enable-shared-pp	\
			--enable-shared		\
			--disable-amr_nb	\
			--disable-amr_nb-fixed	\
			--disable-sunmlib	\
						\
			--cpu=${MYTHTV_ARCH}	\
			--enable-mmx		\
			--disable-altivec	\
			--enable-v4l		\
			--enable-audio-oss	\
			--disable-audio-beos	\
			--enable-dv1394		\
			--enable-network	\
			--enable-zlib		\
			--enable-simple_idct	\
			--disable-vhook		\
			--disable-mpegaudio-hp	\
			--enable-ffserver	\
			--enable-ffplay		\
			--enable-risky

	install -m 0644 ${WORKDIR}/settings.pro ${S}/
	sed 's!PREFIX =.*!PREFIX = ${prefix}!' < settings.pro > settings.pro.new
	mv settings.pro.new settings.pro
}
