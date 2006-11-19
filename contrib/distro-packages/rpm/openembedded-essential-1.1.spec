Summary: Metapackage to install all needed packages to start using OpenEmbedded
Name: openembedded-essential
Version: 1.1
Release: 1
License: MIT
Group: Devel
BuildArch: noarch
BuildRoot: %{_tmppath}/%{name}-%{version}-%{release}
Requires: python, ccache, quilt, sed, bison, wget, cvs, subversion, git-core, monotone, coreutils, unzip, texi2html, texinfo, docbook-utils, gawk

%description
OpenEmbedded is a full-featured development environment allowing users to
target a wide variety of devices. Supporting multiple build, release paths and
configurations, OpenEmbedded extends the capabilities of your build and
release engineers. OpenEmbedded uses compilation and configuration caching at
most levels to increase developer productivity.
This metapackage depends on all software required by OpenEmbedded.



%changelog
* Tue Nov 19 2006 Marcin Juszkiewicz <hrw@openembedded.org> 

openembedded-essential (1.1-1) unstable; urgency=low

  * Added gawk

* Tue Oct 17 2006 Marcin Juszkiewicz <hrw@openembedded.org> 

openembedded-essential (1.0-1) unstable; urgency=low

  * Initial release

%files
/rpm/openembedded-essential-1.1.spec
