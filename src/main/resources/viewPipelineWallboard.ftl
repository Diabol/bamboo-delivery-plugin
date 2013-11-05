<html>
<head>
    <title>Pipelines</title>
    ${webResourceManager.requireResource("se.diabol.bamboo.plugin.pipeline.delivery-pipeline-plugin:delivery-pipeline-plugin-resources")}
    ${webResourceManager.requiredResources}
    <meta name="decorator" content="none">
</head>
<body>
<div id="taskDetails" class="popover">
</div>


<script type="text/javascript">
    var lastResponse = null;
    var pipelineContainers = new Array(1);
</script>

<div id="pipelineerror" class="pipelineerror"></div>

    <script type="text/javascript">
        pipelineContainers[0] = 'pipelines-1';
    </script>
    <div id="pipelines-1" class="left" style="width: 100%;"></div>
<div class="clear"></div>

<script type="text/javascript">
    var jsonUrl = "${context}" + "/rest/pipeline/1.0/pipelines";
    renderPipelines(jsonUrl, pipelineContainers, "pipelineerror", false);
    setInterval(function() {renderPipelines(jsonUrl, pipelineContainers, "pipelineerror", false);}, 2000);
</script>
</body>
</html>
