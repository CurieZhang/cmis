function cleanMyForm()
{
	 $(':input', '#myForm')
	 .not(':button, :submit, :reset, :hidden, :radio, [readonly]') // 去除不需要重置的input类型
	 .val('')
	 .removeAttr('checked')
	 .removeAttr('selected'); // 如果任何radio/checkbox/select inputs有checked or selected 属性，将其移除
}
