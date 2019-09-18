function cleanMyForm()
{
	 $(':input', '#myForm')
	 .not(':button, :submit, :reset, :hidden, :radio, [readonly]') // 去除不需要重置的input类型
	 .val('')
	 .removeAttr('checked')
	 .removeAttr('selected');
}
