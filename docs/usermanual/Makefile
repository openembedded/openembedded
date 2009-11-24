# XSL stylesheets downloaded from http://docbook.sourceforge.net/release/xsl/current/html/

topdir = .
manual = $(topdir)/usermanual.xml
# types = pdf txt rtf ps xhtml html man tex texi dvi
# types = pdf txt
types = $(xmltotypes) $(htmltypes) $(docbooktotypes)
xmltotypes = 
docbooktotypes = dvi pdf ps rtf tex texi txt
htmltypes = html xhtml
htmlxsl = $(if $(filter $@,$(foreach type,$(htmltypes),$(type)-nochunks)),docbook-utf8.xsl,chunk-utf8.xsl)
htmlcssfile = docbook.css
htmlcss = $(topdir)/html.css
# htmlcssfile =
# htmlcss =
cleanfiles = $(foreach i,$(types),$(topdir)/$(i))

ifdef DEBUG
define command
	$(1)
endef
else
define command
	@echo $(2) $(3) $(4)
	@$(1) 
endef
endif

all: $(types)

lint: $(manual) FORCE
	$(call command,xmllint --xinclude --postvalid --noout $(manual),XMLLINT $(manual))

$(types) $(foreach type,$(htmltypes),$(type)-nochunks): lint FORCE

$(foreach type,$(htmltypes),$(type)-nochunks): $(if $(htmlcss),$(htmlcss)) $(manual)
	@mkdir -p $@
ifdef htmlcss
	$(call command,install -m 0644 $(htmlcss) $@/$(htmlcssfile),CP $(htmlcss) $@/$(htmlcssfile))
endif
	$(call command,xsltproc --stringparam base.dir $@/ $(if $(htmlcssfile),--stringparam html.stylesheet $(htmlcssfile)) $(htmlxsl) $(manual) > $@/index.$(patsubst %-nochunks,%,$@),XSLTPROC $@ $(manual))

$(htmltypes): $(if $(htmlcss),$(htmlcss)) $(manual)
	@mkdir -p $@
ifdef htmlcss
	$(call command,install -m 0644 $(htmlcss) $@/$(htmlcssfile),CP $(htmlcss) $@/$(htmlcssfile))
endif
	$(call command,xsltproc --param use.id.as.filename 1 --stringparam base.dir $@/ $(if $(htmlcssfile),--stringparam html.stylesheet $(htmlcssfile)) $(htmlxsl) $(manual),XSLTPROC $@ $(manual))

$(xmltotypes): $(manual)
	$(call command,xmlto --extensions -o $(topdir)/$@ $@ $(manual),XMLTO $@ $(manual))

$(docbooktotypes): $(manual)
	$(call command,docbook2$@ $(manual),DOCBOOK2 $@ $(manual))

clean:
	rm -rf $(cleanfiles)

$(foreach i,$(types) $(foreach type,$(htmltypes),$(type)-nochunks),clean-$(i)):
	rm -rf $(patsubst clean-%,%,$@)

FORCE: 
