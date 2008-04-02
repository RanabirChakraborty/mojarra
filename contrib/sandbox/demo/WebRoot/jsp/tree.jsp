<%@ include file="header.inc" %>
<f:view> 
     <h3>"Value" Binding</h3>
     <risb:tree id="foo">
        <risb:treeNode>
            <f:facet name="label"><h:outputText value="Test 1"/></f:facet>
            <risb:treeNode>
                <f:facet name="label"><h:outputText value="Test 1-1"/></f:facet>
                <risb:treeNode>
                    <f:facet name="label"><h:outputText value="Test 1-1-1"/></f:facet>
                </risb:treeNode>
                <risb:treeNode>
                    <f:facet name="label"><h:outputText value="Test 1-1-2"/></f:facet>
                </risb:treeNode>
                <risb:treeNode>
                    <f:facet name="label"><h:outputText value="A test with one of these: '"/></f:facet>
                </risb:treeNode>
            </risb:treeNode>
        </risb:treeNode>
        <risb:treeNode>
            <f:facet name="label"><h:outputText value="Test 2"/></f:facet>
            <risb:treeNode>
                <f:facet name="label">
                    <h:outputLink value="http://blogs.steeplesoft.com">
                        <h:graphicImage id="image" url="/download.jpg" />
                    </h:outputLink>
                </f:facet>
            </risb:treeNode>
        </risb:treeNode>
     </risb:tree>
     
     <h3>Component Binding</h3>
     <risb:tree binding="#{testBean.tree}"/>
</f:view>
<%@ include file="footer.inc" %>