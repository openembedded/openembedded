
do_tarballing(){

	mkdir -p ${DL_DIR}/sourcepkg/
	cd ${WORKDIR}
	echo '.pc' > tar-exclude
	tar cjvf ${DL_DIR}/sourcepkg/${P}.tar.bz2  `basename ${S}` -X tar-exclude
	md5sum ${DL_DIR}/sourcepkg/${P}.tar.bz2 > ${DL_DIR}/sourcepkg/${P}.tar.bz2.md5
}

addtask tarballing after do_patch before do_configure


