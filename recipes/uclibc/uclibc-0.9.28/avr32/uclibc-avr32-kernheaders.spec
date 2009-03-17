Name: uclibc-avr32-kernheaders
Version: 2.6
Release: 9
License: GPL
Group: Development/System
Summary: AVR32 header files from the Linux kernel for use by uClibc
BuildRoot: %{_tmppath}/uclibc-kernheaders-root
Source: linux-2.6.16.tar.bz2
Source1: linux-dot-config
Patch0: linux-2.6.16.11.patch
Patch1: linux-2.6.16.11-avr32-20060626.patch

%description
uclibc-avr32-kernheaders contain C header files from the Linux kernel
which are necessary for building the uClibc library. These header
files are also necessary for developing programs which use the standard
C libraries.

If you are developing programs which wil use the standard C libraries,
you should install uclibc-avr32-kernheaders.

%prep
%setup -q -n linux-2.6.16
%patch0 -p1
%patch1 -p1
cp %{SOURCE1} .config

%build
make prepare-all ARCH=avr32 CROSS_COMPILE=avr32-linux-

%install
mkdir -p %{buildroot}/usr/avr32-linux/include
cp -a include/{linux,asm,asm-avr32,asm-generic} %{buildroot}/usr/avr32-linux/include


%clean
rm -rf %{buildroot}

%files
%defattr(-,root,root)
/usr/avr32-linux/include
