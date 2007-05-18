require icu-3.6.inc

do_configure_append() {
        for i in */Makefile */*.inc */*/Makefile */*/*.inc ; do
		sed -i -e 's:$(INVOKE) $(BINDIR)/:$(INVOKE) :g' $i
		sed -i -e 's:$(BINDIR)/::g' $i
        done
	sed -i -e 's:$(BINDIR)/::g' extra/uconv/pkgdata.inc

}
