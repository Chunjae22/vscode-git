function init_boundary() {
    $('.선택자').parent('tr').addClass('boundary');
    $('.선택자').parent('tr').children('th').css({'border-top':'2px solid #ffa436'});
    $('.선택자').closest('tbody').children('tr:first-child').children('th').css({'border-top':''});
}
